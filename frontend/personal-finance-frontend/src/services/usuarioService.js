export async function crudUsuarios(method = "GET", endpoint = "", data = null) {

    const options = {
        method,
        headers: {
            "Content-Type": "application/json"
        }
    };

    if (data) {
        options.body = JSON.stringify(data);
    }

    const response = await fetch(
        `http://localhost:8080/usuarios${endpoint}`,
        options
    );

    if (!response.ok) {
        throw new Error("Error al consumir la API");
    }

    if (response.status === 204) {
        return null;
    }

    return await response.json();
}