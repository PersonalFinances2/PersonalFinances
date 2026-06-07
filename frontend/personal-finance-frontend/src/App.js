import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from './components/login/Login';
import ResumenFinanciero from './components/movimientos/ResumenFinanciero';
import MetaPage from './pages/MetaPage';
import UsuarioPage from './pages/UsuarioPage';
import ProtectedRoute from './services/auth/ProtectedRoute';
import HomePage from './pages/HomePage';
import UsuarioForm from './components/usuario/UsuarioForm';
import UsuarioList from './pages/UsuarioList';

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
            <ProtectedRoute>
              <MetaPage />
            </ProtectedRoute>
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
            <UsuarioPage />
          }
        />

        <Route
          path="/listausuario"
          element={
            <ProtectedRoute> 
              <UsuarioList />  
            </ProtectedRoute>
          }
        />
      </Routes>

    </BrowserRouter>
  );
}

export default App;