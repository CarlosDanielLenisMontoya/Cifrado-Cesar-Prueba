async function darPista() {
    try {
        // Obtener valores del formulario
        const mensaje = document.getElementById("mensajeOriginal").value;
        const pista = document.getElementById("pista").value;

        // Verificar si los campos están vacíos
        if (mensaje.trim() === '' || pista.trim() === '') {
            throw new Error('Por favor, complete ambos campos.');
        }

        // Preparar los datos para la solicitud POST
        const data = new URLSearchParams();
        data.append('textoCodificado', mensaje);
        data.append('pista', pista);

        // Hacer la solicitud fetch al servicio de cifrado
        const response = await fetch('http://localhost:8080/cifrado-service/pista', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: data,
        });

        // Verificar si la solicitud fue exitosa (código de estado 200)
        if (response.ok) {
            const result = await response.json();
            console.log('Resultado:', result.resultado);
            document.getElementById("resultado").textContent = result.resultado; // Asumiendo que tu respuesta tiene una propiedad llamada 'resultado'
        } else {
            console.error('Error:', response.status, response.statusText);
        }
    } catch (error) {
        console.error('Error durante la operación fetch:', error.message);

        // Mostrar el mensaje de error en la página
        document.getElementById("errorMensaje").textContent = error.message;
    }
}
