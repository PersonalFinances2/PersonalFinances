import MovimientoForm from "../components/movimientos/MovimientoForm";
import Navbar from "../components/navbar/Navbar";

function MovimientoFormPage() {
    return (
        <div>
            <Navbar />
            <div className="page-container">
                <MovimientoForm />
            </div>
        </div>
    );
}

export default MovimientoFormPage;