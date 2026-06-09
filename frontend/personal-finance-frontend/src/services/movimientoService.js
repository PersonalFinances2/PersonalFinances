import { authHeader } from "./auth/authHeader";

const API_URL = "http://localhost:8080/movimientos";

export async function crudMovimientos() {

    const response = await fetch(API_URL, {
        headers: {
            ...authHeader()
        }
    });

    if (!response.ok) {
        throw new Error(
            "Error al conectar con el controlador de movimientos"
        );
    }

    return await response.json();
}

export async function getAllMovimientos() {

    const response = await fetch(
        `${API_URL}/movimientos`,
        {
            headers: {
                ...authHeader()
            }
        }
    );

    if (!response.ok) {
        throw new Error(
            "Error al obtener movimientos"
        );
    }

    return await response.json();
}

export async function crearMovimiento(movimiento) {

    const response = await fetch(
        `${API_URL}/nuevo`,
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                ...authHeader()
            },
            body: JSON.stringify(movimiento)
        }
    );

    if (!response.ok) {
        throw new Error(
            "Error al crear movimiento"
        );
    }

    return await response.json();
}