import { useEffect, useState } from "react";
import { crudUsuarios } from "../../services/usuarioService";
import { obtenerTiposDocumento } from "../../services/tipoDocumentoService";
import "./UsuarioForm.css";

function UsuarioForm({ agregarUsuario }) {
  const [usuario, setUsuario] = useState({
    nombre: "",
    apellido: "",
    idTipoDocumento: "",
    documento: "",
    username: "",
    contrasenia: ""
  });

  const [tiposDocumento, setTiposDocumento] = useState([]);

  const handleChange = (e) => {
    setUsuario({
      ...usuario,
      [e.target.name]: e.target.value
    });
  };


  useEffect(() => {

    async function cargarTiposDocumento() {
      try {

        const data = await obtenerTiposDocumento();

        setTiposDocumento(data);

      } catch (error) {
        console.error(error);
      }
    }

    cargarTiposDocumento();

  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {

      const usuarioDto = {
        nombre: usuario.nombre,
        apellido: usuario.apellido,
        idTipoDocumento: Number(usuario.idTipoDocumento),
        documento: usuario.documento,
        username: usuario.username,
        contrasenia: usuario.contrasenia
      };

      const respuesta = await crudUsuarios(
        "POST",
        "/crearusuario",
        usuarioDto
      );

      console.log("Usuario creado:", respuesta);

      alert("Usuario registrado correctamente");

      if (agregarUsuario) {
        agregarUsuario(respuesta);
      }

      setUsuario({
        nombre: "",
        apellido: "",
        idTipoDocumento: "",
        documento: "",
        username: "",
        contrasenia: ""
      });

    } catch (error) {
      console.error(error);
      alert("Error al registrar usuario");
    }
  };

  return (
    <div className="usuario-container">
      <h2>Registro de Usuario</h2>

      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="nombre"
          placeholder="Nombre"
          value={usuario.nombre}
          onChange={handleChange}
        />

        <input
          type="text"
          name="apellido"
          placeholder="Apellido"
          value={usuario.apellido}
          onChange={handleChange}
        />

        <select
          name="idTipoDocumento"
          value={usuario.idTipoDocumento}
          onChange={handleChange}
        >
          <option value="">
            Seleccione un documento
          </option>

          {tiposDocumento.map((tipo) => (
            <option
              key={tipo.idTipoDocumento}
              value={tipo.idTipoDocumento}
            >
              {tipo.nombre}
            </option>
          ))}
        </select>

        <input
          type="number"
          name="documento"
          placeholder="Documento"
          value={usuario.documento}
          onChange={handleChange}
        />

        <input
          type="text"
          name="username"
          placeholder="Username"
          value={usuario.username}
          onChange={handleChange}
        />

        <input
          type="password"
          name="contrasenia"
          placeholder="Contraseña"
          value={usuario.contrasenia}
          onChange={handleChange}
        />

        <button type="submit">Guardar</button>
      </form>
    </div>
  );
}

export default UsuarioForm;