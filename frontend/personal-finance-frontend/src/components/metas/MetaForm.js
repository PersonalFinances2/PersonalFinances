import { useEffect, useState } from "react";
import { crudMetas } from "../../services/metaService";
import "./MetaForm.css"

function MetaForm({
    obtenerMetas,
    metaEditar,
    setMetaEditar
}) {

    const [meta, setMeta] = useState({
        nombre: "",
        monto: "",
        usuario: {
            idUsuario: ""
        }
    });

    useEffect(() => {

        if (metaEditar) {

            setMeta({
                nombre: metaEditar.nombre,
                monto: metaEditar.monto,
                usuario: {
                    idUsuario: metaEditar.usuario?.idUsuario || ""
                }
            });
        }

    }, [metaEditar]);

    function handleChange(e) {

        const { name, value } = e.target;

        if (name === "idUsuario") {

            setMeta({
                ...meta,
                usuario: {
                    idUsuario: value
                }
            });

        } else {

            setMeta({
                ...meta,
                [name]: value
            });
        }
    }

    async function handleSubmit(e) {

        e.preventDefault();

        try {

            const body = {
                idMeta: metaEditar?.idMeta,
                nombre: meta.nombre,
                monto: parseFloat(meta.monto),
                usuario: {
                    idUsuario: parseInt(meta.usuario.idUsuario)
                }
            };

            if (metaEditar) {

                await crudMetas(
                    "PUT",
                    metaEditar.idMeta,
                    body
                );

                alert("Meta actualizada");

            } else {

                await crudMetas(
                    "POST",
                    "",
                    body
                );

                alert("Meta creada");
            }

            setMeta({
                nombre: "",
                monto: "",
                usuario: {
                    idUsuario: ""
                }
            });

            setMetaEditar(null);

            await obtenerMetas();

        } catch (error) {

            console.error(error);
            alert("Error al guardar");
        }
    }

    return (

        <div className="meta-form-container">
            <h2 className="meta-form-title">
                Registrar Meta
            </h2>
            <form className="meta-form" onSubmit={handleSubmit}>
                <div className="meta-form-group">
                    <label>Nombre:</label>
                    <input
                        type="text"
                        placeholder="Ingrese el nombre de la meta"
                        name="nombre"
                        value={meta.nombre}
                        onChange={handleChange}
                    />
                </div>

                <div className="meta-form-group">
                    <label>Monto:</label>
                    <input
                        type="number"
                        placeholder="Ingrese el monto"
                        name="monto"
                        value={meta.monto}
                        onChange={handleChange}
                    />
                </div>                

                <div lassName="meta-form-buttons">
                    <button type="submit"
                        type="submit"
                        className="btn-guardar">
                        {
                            metaEditar
                                ? "Actualizar"
                                : "Guardar"
                        }
                    </button>
                </div>

            </form>
        </div>
    );
}

export default MetaForm;