async function descodificar() {
    try {
        // Obtener valores del formulario
        const mensaje = document.getElementById("mensaje").value;
        const clave = document.getElementById("clave").value;

        // Verificar si ambos campos están llenos
        if (!mensaje || !clave) {
            throw new Error('Por favor, completa ambos campos.');
        }

        // Restablecer el mensaje de error y ocultar la sección de mensajes de error
        document.getElementById("errorMensaje").textContent = "";
        document.getElementById("errorSection").style.display = "none";

        // Preparar los datos para la solicitud POST
        const data = new URLSearchParams();
        data.append('texto', mensaje);
        data.append('desplazamiento', clave);

        // Hacer la solicitud fetch al servicio de descodificación
        const response = await fetch('http://localhost:8080/cifrado-service/descodificar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: data,
        });

        // Verificar si la solicitud fue exitosa (código de estado 200)
        if (response.ok) {
            const result = await response.json();
            document.getElementById("resultado").textContent = result.textoDescodificado;
        } else {
            console.error('Error:', response.status, response.statusText);
        }
    } catch (error) {
        // Mostrar el mensaje de error en la página
        document.getElementById("errorMensaje").textContent = error.message;
        // Hacer visible la sección de mensajes de error
        document.getElementById("errorSection").style.display = "block";
        console.error('Error durante la operación fetch:', error);
    }
}
