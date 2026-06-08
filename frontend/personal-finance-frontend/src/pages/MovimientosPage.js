import { Link } from "react-router-dom";
import MovimientoList from "../components/movimientos/MovimientoList";
import "./MovimientosPage.css";

function MovimientosPage() {
  return (
    <div className="movimientos-page">

      <div className="header-movimientos">
        <h1>Movimientos</h1>

        <Link to="/movimientos/nuevo">
          <button className="btn-nuevo">
            + Nuevo Ingreso
          </button>
        </Link>
      </div>

      <div className="buscador">
        <input
          type="text"
          placeholder="Buscar movimiento..."
        />
      </div>

      <MovimientoList />

    </div>
  );
}

export default MovimientosPage;