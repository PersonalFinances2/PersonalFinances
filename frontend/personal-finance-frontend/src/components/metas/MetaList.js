import { crudMetas } from "../../services/metaService";
import "./MetaList.css"

function MetaList({ metas, setMetaEditar, obtenerMetas}) {

     async function eliminarMeta(idMeta) {

        const confirmar = window.confirm(
            "¿Deseas eliminar esta meta?"
        );

        if (!confirmar) {
            return;
        }

        try {

            await crudMetas(
                "DELETE",
                idMeta
            );

            alert("Meta eliminada");

            await obtenerMetas();

        } catch (error) {

            console.error(error);

            alert("Error al eliminar");
        }
    }

    if (metas.length === 0) {
        return <p>No hay metas registradas</p>;
    }

    return (

        <div className="lista-metas-container">
            <h2 className="lista-metas-titulo">
                Lista de metas</h2>

            <table className="tabla-metas">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Monto</th>
                        <th>Usuario</th>
                        <th>Acciones</th>
                    </tr>
                </thead>

                <tbody>
                    {metas.map((meta) => (
                        <tr key={meta.idMeta}>
                            <td>{meta.idMeta}</td>

                            <td>{meta.nombre}</td>

                            <td>{meta.monto}</td>

                            <td>{meta.usuario?.idUsuario}</td>

                            <td> 
                                <button
                                    className="btn-editar" 
                                    onClick={() => setMetaEditar(meta)}>                            
                                    Editar
                                </button>  

                                <button                                    
                                    className="btn-eliminar"
                                    onClick={() => eliminarMeta(meta.idMeta)}>
                                    Eliminar
                                </button>                              
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default MetaList;