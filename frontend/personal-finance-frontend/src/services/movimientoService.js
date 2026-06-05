import { authHeader } from "./auth/authHeader";

const API_URL = "http://localhost:8080/movimientos";

export async function crudMovimientos() {
    
    const response = await fetch(API_URL,{
        headers: {
            ...authHeader()
        }
    });

    if (!response.ok){
        throw new Error("Error al conectar con el controlador de metas");
    }
    return await response.json();
}