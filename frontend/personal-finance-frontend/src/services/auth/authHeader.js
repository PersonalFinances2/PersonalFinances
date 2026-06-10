import { getToken } from "../authService";

export function authHeader() {
    return {
        Authorization: `Bearer ${getToken()}`
    };
}