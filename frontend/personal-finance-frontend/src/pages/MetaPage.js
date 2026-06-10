import { useEffect, useState } from "react";
import MetaForm from "../components/metas/MetaForm";
import { crudMetas } from "../services/metaService";
import MetaList from "../components/metas/MetaList";
import Navbar from "../components/navbar/Navbar";
import ResumenFinanciero from "../components/movimientos/ResumenFinanciero";

function MetaPage() {

    const [metas, setMetas] = useState([]);

    const [metaEditar, setMetaEditar] = useState(null);
    
    async function obtenerMetas() {
        try {

            const response = await crudMetas("GET");

            setMetas(response);
            
        } catch (error) {

            console.error(error);
            
        }        
    }
    useEffect(() => {
        obtenerMetas();
    }, []);

    return(
        <div>      
            <Navbar />
            <MetaForm 
            obtenerMetas={obtenerMetas} 
            metaEditar={metaEditar}
            setMetaEditar={setMetaEditar}
            />
            <hr />
            <MetaList 
            metas={metas} 
            setMetaEditar={setMetaEditar}
            obtenerMetas={obtenerMetas}
            />
        </div>
    );
}
export default MetaPage;