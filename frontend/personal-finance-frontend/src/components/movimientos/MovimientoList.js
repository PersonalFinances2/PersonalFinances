import React from 'react';
import "./MovimientoList.css";

function MovimientoList() {

  const movimientos = [
    {
      id: 1,
      titulo: "Salario",
      descripcion: "Pago mensual",
      tipo: "INGRESO",
      monto: 2500000
    },
    {
      id: 2,
      titulo: "Mercado",
      descripcion: "Compra supermercado",
      tipo: "GASTO",
      monto: 180000
    }
  ];

  return (
    <div className="movimientos-container">

      {movimientos.map((movimiento) => (

        <div
          key={movimiento.id}
          className="movimiento-card"
        >

          <div className="movimiento-info">
            <h3>{movimiento.titulo}</h3>
            <p>{movimiento.descripcion}</p>
          </div>

          <div
            className={
              movimiento.tipo === "INGRESO"
                ? "monto ingreso"
                : "monto gasto"
            }
          >
            {movimiento.tipo === "INGRESO" ? "+" : "-"}
            ${movimiento.monto.toLocaleString()}
          </div>

        </div>
      ))}

    </div>
  );
}

export default MovimientoList;