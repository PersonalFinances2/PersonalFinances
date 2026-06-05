import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from './components/login/Login';
import ResumenFinanciero from './components/movimientos/ResumenFinanciero';
import MetaPage from './pages/MetaPage';
import UsuarioPage from './pages/UsuarioPage';
import ProtectedRoute from './services/auth/ProtectedRoute';
import HomePage from './pages/HomePage';
import UsuarioForm from './components/usuario/UsuarioForm';

function App() {

  return (
    <BrowserRouter>

      <Routes>

        <Route
          path="/"
          element={<Login />}
        />

        <Route
          path="/metas"
          element={
            
              <MetaPage />
            
          }
        />

        <Route
          path="/resumenfinanciero"
          element={
            <ProtectedRoute>
              <ResumenFinanciero />
            </ProtectedRoute>
          }
        />

        <Route
          path="/home"
          element={
            <ProtectedRoute>
              <HomePage />
            </ProtectedRoute>
          }
        />
        <Route
          path="/usuarios"
          element={
          
              <UsuarioForm />
            
          }
        />

      </Routes>

    </BrowserRouter>
  );
}

export default App;