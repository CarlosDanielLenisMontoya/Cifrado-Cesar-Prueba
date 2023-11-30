async function darPista() {
    try {
        // Obtener valores del formulario
        const mensajeOriginal = document.getElementById("mensajeOriginal").value;
        const pista = document.getElementById("pista").value;

        // Verificar si los campos están vacíos
        if (mensajeOriginal.trim() === '' || pista.trim() === '') {
            throw new Error('Por favor, complete ambos campos.');
        }

        // Preparar los datos para la solicitud POST
        const data = new URLSearchParams();
        data.append('textoOriginal', mensajeOriginal);
        data.append('pista', pista);

        // Hacer la solicitud fetch al servicio de pista
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

            // Mostrar resultados en la página
            document.getElementById("resultado").textContent = `Texto: ${result.texto}\nPista: ${result.pista}\nDesplazamiento: ${result.desplazamiento}`;
            
        } else {
            console.error('Error:', response.status, response.statusText);
        }
    } catch (error) {
        console.error('Error durante la operación fetch:', error.message);

        // Mostrar el mensaje de error en la página
        document.getElementById("errorMensaje").textContent = error.message;
    }
}
