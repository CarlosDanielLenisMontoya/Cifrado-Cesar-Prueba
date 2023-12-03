 // Función para dar pista
 function darPista() {
    // Obtener los valores de los campos de entrada
    var mensajeOriginal = document.getElementById("mensajeOriginal").value;
    var pista = document.getElementById("pista").value;

    // Verificar si ambos campos están llenos
    if (mensajeOriginal.trim() === '' || pista.trim() === '') {
        // Mostrar una alerta si no están llenos
        alert("Por favor, llene ambos campos para continuar.");
        return;
    }

    // Hacer la solicitud a la API usando fetch
    fetch('http://localhost:8080/cifrado-service/pista', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: 'textoCifrado=' + encodeURIComponent(mensajeOriginal) + '&pista=' + encodeURIComponent(pista),
    })
    .then(response => response.json()) // Suponiendo que la respuesta está en formato JSON
    .then(data => {
        // Manejar los datos de la respuesta
        console.log(data);

        // Actualizar el elemento de resultado con los datos recibidos
        var resultElement = document.getElementById("resultado");
        resultElement.innerHTML = `
            <p>Descodificación: ${data.textoDescifrado}</p>
            <p>Desplazamiento: ${data.desplazamiento}</p>
        `;
    })
    .catch(error => {
        console.error('Error durante la operación fetch:', error.message);
        console.error('Error:', error);

      
    });
}