import { useContext } from 'react';
import './CartSummary.css';
import { AppContext } from '../../context/AppContext.jsx';
import Receipt from '../Receipt/Receipt.jsx';
import { useNavigate } from 'react-router-dom';

const CartSummary = () => {

  const { cartItems } = useContext(AppContext);
  const navigate = useNavigate();

  const totalAmount = cartItems.reduce((total, item) => total + (item.price * item.quantity), 0);

  const tax = totalAmount * 0.105;

  const finalAmount = totalAmount + tax;

  return (
    <div className="mt-2">
      <div className="cart-summary-details">
        <div className="d-flex justify-content-between mb-2">
          <span className="text-light">Item: </span>
          <span className="text-light">${totalAmount.toFixed(2)}</span>
        </div>
        <div className="d-flex justify-content-between mb-2">
          <span className="text-light">Tax (10.5%):</span>
          <span className="text-light">${tax.toFixed(2)}</span>
        </div>
        <div className="d-flex justify-content-between mb-3">
          <span className="text-light">Total:</span>
          <span className="text-light">${finalAmount.toFixed(2)}</span>
        </div>
      </div>

      <div className="d-flex gap-3">
        <button className="btn btn-success flex-grow-1">Cash</button>
        <button className="btn btn-primary flex-grow-1" onClick={() => navigate('/paypalpayment')}>Card</button>
      </div>

      <div className="d-flex gap-3 mt-3">
        <button className="btn btn-warning flex-grow-1">Place Order</button>
      </div>
    </div>
  )
}

export default CartSummary;