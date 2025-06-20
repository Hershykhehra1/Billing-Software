import { useContext } from 'react';
import { PayPalButtons } from "@paypal/react-paypal-js";
import { AppContext } from '../../context/AppContext';
import toast from 'react-hot-toast';

const PaypalPayment = () => {
    const { cartItems } = useContext(AppContext);

    const totalAmount = cartItems.reduce((total, item) => total + (item.price * item.quantity), 0);
    const tax = totalAmount * 0.105;
    const finalAmount = totalAmount + tax;

    const createOrder = (data, actions) => {
        return actions.order.create({
            purchase_units: [
                {
                    amount: {
                        value: finalAmount.toFixed(2),
                    },
                },
            ],
        });
    };

    const onApprove = (data, actions) => {
        return actions.order.capture().then((details) => {
            toast.success('Payment successful');
            console.log('Payment details:', details);
        });
    };

    const onError = (err) => {
        toast.error('An error occurred during the payment');
        console.error('Paypal Error:', err);
    }

    return (
        <div className="d-flex flex-column align-items-center justify-content-center" style={{ minHeight: '80vh' }}>
            <h2>Paypal Payment</h2>
            <div style={{ marginTop: 32, width: '300px' }}>
                {finalAmount > 0 ? (
                    <PayPalButtons
                        style={{ layout: "vertical" }}
                        createOrder={createOrder}
                        onApprove={onApprove}
                        onError={onError}
                    />
                ) : (
                    <p>Your cart is empty.</p>
                )}
            </div>
        </div>
    );
};

export default PaypalPayment; 