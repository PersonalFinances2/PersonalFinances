import { useState } from "react";
import "./MovimientoForm.css";

function MovimientoForm() {
  const [movimiento, setMovimiento] = useState({
    titulo: "",
    descripcion: "",
    fecha: "",
    tipo_movimiento: "",
    monto: "",
    id_categoria: ""
  });

  const handleChange = (e) => {
    setMovimiento({
      ...movimiento,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    console.log(movimiento);

    
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

        <label>Fecha</label>
        <input
          type="date"
          name="fecha"
          value={movimiento.fecha}
          onChange={handleChange}
          required
        />

        <label>Tipo de movimiento</label>
        <select
          name="tipo_movimiento"
          value={movimiento.tipo_movimiento}
          onChange={handleChange}
          required
        >
          <option value="">Seleccione</option>
          <option value="INGRESO">Ingreso</option>
          <option value="GASTO">Gasto</option>
        </select>

        <label>Monto</label>
        <input
          type="number"
          name="monto"
          value={movimiento.monto}
          onChange={handleChange}
          required
        />

        <label>Categoría</label>
        <input
          type="number"
          name="id_categoria"
          value={movimiento.id_categoria}
          onChange={handleChange}
          required
        />

        <button type="submit">
          Guardar Movimiento
        </button>

      </form>
    </div>
  );
}

export default MovimientoForm;