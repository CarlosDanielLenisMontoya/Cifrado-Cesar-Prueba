async function cifrar() {
    try {
        // Obtener valores del formulario
        const mensaje = document.getElementById("mensaje").value;
        const clave = document.getElementById("clave").value;

        // Verificar si los campos están vacíos
        if (mensaje.trim() === '' || clave.trim() === '') {
            throw new Error('Por favor, complete ambos campos.');
        }

        // Preparar los datos para la solicitud POST
        const data = new URLSearchParams();
        data.append('texto', mensaje);
        data.append('desplazamiento', clave);

        // Hacer la solicitud fetch al servicio de cifrado
        const response = await fetch('http://localhost:8080/cifrado-service/codificar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: data,
        });

        // Verificar si la solicitud fue exitosa (código de estado 200)
        if (response.ok) {
            const result = await response.json();
            console.log('Resultado:', result.textoCodificado);

            // Actualizar el elemento de resultado en la página
            document.getElementById("resultado").textContent = result.textoCodificado; // Asumiendo que tu respuesta tiene una propiedad llamada 'textoCodificado'
        } else {
            console.error('Error:', response.status, response.statusText);
        }
    } catch (error) {
        console.error('Error durante la operación fetch:', error.message);

        // Mostrar el mensaje de error como una alerta
        alert(error.message); 
    }
}
