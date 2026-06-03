import { useEffect, useState } from "react";
import { Doughnut } from "react-chartjs-2";
import "./ResumenFinanciero.css"

import {
    Chart as ChartJS,
    ArcElement,
    Tooltip,
    Legend
} from "chart.js";

import { crudMovimientos } from "../../services/movimientoService";

ChartJS.register(
    ArcElement,
    Tooltip,
    Legend
);

function ResumenFinanciero() {

    const [resumen, setResumen] = useState(null);

    useEffect(() => {
        obtenerResumen();
    }, []);

    async function obtenerResumen() {
        try {
            const data = await crudMovimientos();
            setResumen(data);
        } catch (error) {
            console.error(error);
        }
    }

    if (!resumen) {
        return <p>Cargando resumen...</p>;
    }

    const data = {
        labels: ["Ingresos", "Gastos", "Ahorro"],
        datasets: [
            {
                data: [
                    resumen.ingresos,
                    resumen.gastos,
                    resumen.ahorro
                ],
                backgroundColor: [
                    "#198754",
                    "#dc3545",
                    "#0d6efd"
                ]
            }
        ]
    };

    const options = {
        responsive: true,
        maintainAspectRatio: false,

        rotation: -90,
        circumference: 180,

        plugins: {
            legend: {
                position: "bottom"
            }
        }
    };

    return (
        <div className="resumen-container">

            <h2>Resumen financiero</h2>

            <div className="grafico-container">
                <Doughnut
                    data={data}
                    options={options}
                />
            </div>

            <div className="resumen-cards">

                <div className="card ingreso">
                    <h3>Ingresos</h3>
                    <p>
                        ${resumen.ingresos.toLocaleString()}
                    </p>
                </div>

                <div className="card gasto">
                    <h3>Gastos</h3>
                    <p>
                        ${resumen.gastos.toLocaleString()}
                    </p>
                </div>

                <div className="card ahorro">
                    <h3>Ahorro</h3>
                    <p>
                        ${resumen.ahorro.toLocaleString()}
                    </p>
                </div>

            </div>

        </div>
    );
}

export default ResumenFinanciero;