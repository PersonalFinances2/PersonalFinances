const API_URL = "http://localhost:8080/metas";

export async function crudMetas(method = "GET", id = "", data = null) {
    
    const options = {
        method,
        headers: {
            "Content-Type": "application/json"
        }
    };
    if (data){
        options.body = JSON.stringify(data);
    }

    const response = await fetch(
        id ? `${API_URL}/${id}` : API_URL,
        options
    );

    if (!response.ok){
        throw new Error("Error al conectar con el controlador de metas");
    }
    return await response.json();
}