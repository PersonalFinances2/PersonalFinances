import React, { useEffect, useState } from 'react';
import { getAllMovimientos } from '../../services/movimientoService';
import "./MovimientoList.css";

function MovimientoList({ busqueda }) {

  const [movimientos, setMovimientos] = useState([]);

  useEffect(() => {
    obtenerMovimientos();
  }, []);

  async function obtenerMovimientos() {
    try {

      const data = await getAllMovimientos();

      setMovimientos(data);

    } catch (error) {

      console.error(error);

    }
  }

  const movimientosFiltrados = movimientos.filter(
    (movimiento) =>
      movimiento.titulo
        .toLowerCase()
        .includes(busqueda.toLowerCase())
  );

  return (
    <div className="movimientos-container">

      {
        movimientos.length === 0 &&
        <p>No hay movimientos registrados.</p>
      }

      {
        movimientosFiltrados.length === 0 &&
        (
          <p className="sin-resultados">
            No se encontraron movimientos.
          </p>
        )
      }

      {movimientosFiltrados.map((movimiento) => (

        <div
          key={movimiento.idMovimiento}
          className="movimiento-card"
        >

          <div className="movimiento-info">
            <h3>{movimiento.titulo}</h3>
            <p>{movimiento.descripcion}</p>
            <p className="fecha">
              {new Date(movimiento.fecha).toLocaleDateString()}
            </p>
          </div>

          <div
            className={
              movimiento.idCategoria === 1
                ? "monto ingreso"
                : "monto gasto"
            }
          >
            {movimiento.idCategoria === 1 ? "+" : "-"}
            ${movimiento.monto.toLocaleString()}
          </div>

        </div>
      ))}

    </div>
  );
}

export default MovimientoList;