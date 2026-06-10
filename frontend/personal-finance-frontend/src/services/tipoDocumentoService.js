const API_URL = "http://localhost:8080/tipo-documento";

export async function obtenerTiposDocumento() {

    const response = await fetch(API_URL);

    if (!response.ok) {
        throw new Error("Error obteniendo tipos de documento");
    }

    return await response.json();
}