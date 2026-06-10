import { Link } from "react-router-dom";
import { useState } from "react";
import MovimientoList from "../components/movimientos/MovimientoList";
import "./MovimientosPage.css";
import Navbar from "../components/navbar/Navbar";

function MovimientosPage() {
  const [busqueda, setBusqueda] = useState("");
  return (
    <div>
      <Navbar />

      <div className="movimientos-page">

        <div className="header-movimientos">
          <h1>Movimientos</h1>

          <Link to="/nuevo/movimiento">
            <button className="btn-nuevo">
              Nuevo movimiento
            </button>
          </Link>
        </div>

        <div className="buscador">
          <input
            type="text"
            placeholder="Buscar movimiento..."
            value={busqueda}
            onChange={(e) =>
              setBusqueda(e.target.value)
            }
          />
        </div>

        <MovimientoList busqueda={busqueda}/>

      </div>
    </div>
  );
}

export default MovimientosPage;