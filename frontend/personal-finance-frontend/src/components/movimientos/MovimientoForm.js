import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { crearMovimiento } from "../../services/movimientoService";
import "./MovimientoForm.css";

function MovimientoForm() {

  const navigate = useNavigate();
  const fechaActual = new Date().toISOString().split("T")[0];

  const [movimiento, setMovimiento] = useState({
    titulo: "",
    descripcion: "",
    monto: "",
    fecha: "",
    idCategoria: ""
  });

  const handleChange = (e) => {
    setMovimiento({
      ...movimiento,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const hoy = new Date().toISOString().split("T")[0];

    if (movimiento.fecha > hoy) {
        alert("La fecha no puede ser superior a la fecha actual");
        return;
    }

    try {

      const nuevoMovimiento = {
        titulo: movimiento.titulo,
        descripcion: movimiento.descripcion,
        monto: Number(movimiento.monto),
        fecha: movimiento.fecha,
        idCategoria: Number(
          movimiento.idCategoria
        )
      };

      await crearMovimiento(nuevoMovimiento);

      alert("Movimiento registrado correctamente");
      navigate("/Lista/movimientos");

      setMovimiento({
        titulo: "",
        descripcion: "",
        monto: "",
        fecha: "",
        idCategoria: ""
      });

    } catch (error) {

      console.error(error);

      alert(
        "Error al registrar movimiento"
      );
    }
  };

  return (
    <div className="form-container">
      <h2>Registrar Movimiento</h2>

      <form onSubmit={handleSubmit}>

        <label>Título</label>
        <input
          type="text"
          name="titulo"
          value={movimiento.titulo}
          onChange={handleChange}
          required
        />

        <label>Descripción</label>
        <textarea
          name="descripcion"
          value={movimiento.descripcion}
          onChange={handleChange}
          required
        />

        <label>Monto</label>
        <input
          type="number"
          name="monto"
          value={movimiento.monto}
          onChange={handleChange}
          required
        />

        <label>Fecha</label>
        <input
          type="date"
          name="fecha"
          value={movimiento.fecha}
          onChange={handleChange}
          required
        />

        <label>Categoría</label>
        <select
          name="idCategoria"
          value={movimiento.idCategoria}
          onChange={handleChange}
          max={fechaActual}
          required
        >
          <option value="">Seleccione</option>
          <option value="1">Ingreso</option>
          <option value="2">Gasto</option>
        </select>

        <button type="submit">
          Guardar Movimiento
        </button>

      </form>
    </div>
  );
}

export default MovimientoForm;