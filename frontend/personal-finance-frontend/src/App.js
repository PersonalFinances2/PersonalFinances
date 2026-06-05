import './App.css';
import ResumenFinanciero from './components/movimientos/ResumenFinanciero';
import UsuarioForm from './components/usuario/UsuarioForm';
import MetaPage from './pages/MetaPage';

function App() {
  return (
    <div>
      <h1>Personal Finance</h1>
      <ResumenFinanciero />
      <MetaPage />
      <UsuarioForm />
    </div>
  );
}

export default App;
