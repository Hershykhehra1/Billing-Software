import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.bundle.js';
import 'bootstrap-icons/font/bootstrap-icons.css';
import { BrowserRouter } from 'react-router-dom';
import { AppContextProvider } from './context/AppContext.jsx';
import { PayPalScriptProvider } from '@paypal/react-paypal-js';



createRoot(document.getElementById('root')).render(
    <BrowserRouter>
        <PayPalScriptProvider options={{ "client-id": "AanoL7gaROSjqFKqc9-GgV8wFsk2YwWo5txj6R_6LXsO9AW14FL802rZSvuORL3wtHalH6ZsA601QhYO" }}>
            <AppContextProvider>
                <App />
            </AppContextProvider>
        </PayPalScriptProvider>
    </BrowserRouter>
)
