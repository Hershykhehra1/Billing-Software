import './Explore.css';
import { AppContext } from "../../context/AppContext.jsx";
import DisplayCategory from "../../components/DisplayCategory/DisplayCategory.jsx";
import DisplayItems from "../../components/DisplayItems/DisplayItems.jsx";
import CustomerForm from "../../components/CustomerForm/CustomerForm.jsx";
import CartItems from "../../components/CartItems/CartItems.jsx";
import CartSummary from "../../components/CartSummary/CartSummary.jsx";
import { useContext, useState } from 'react';

const Explore = () => {
    const {categories} = useContext(AppContext);
    const [selectedCategory, setSelectedCategory] = useState("");
    const [customerName, setCustomerName] = useState("");
    const [phoneNumber, setPhoneNumber] = useState("");

    return (
        <div className="explore-container text-light">
            <div className="left-column">
                <div className="first-row" style={{overflowY: 'auto'}}>
                    <DisplayCategory 
                        categories={categories}
                        selectedCategory={selectedCategory}
                        setSelectedCategory={setSelectedCategory} />
                </div>
                <hr className="horizontal-line" />
                <div className="second-row" style={{overflowY: 'auto'}}>
                    <DisplayItems selectedCategory={selectedCategory}/>
                </div>
            </div>
            <div className="right-column d-flex flex-column">
                <div className="customer-form-container" style={{height: '15%'}}>
                    <CustomerForm 
                        customerName={customerName}
                        phoneNumber={phoneNumber}
                        setCustomerName={setCustomerName}
                        setPhoneNumber={setPhoneNumber} />
                </div>
                <hr className="my-3 text-light" />
                <div className="cart-items-container" style={{height: '55%', overflowY: 'auto'}}>
                    <CartItems />
                </div>
                <div className="cart-summary-container" style={{height: '30%'}}>
                    <CartSummary />
                </div>
            </div>
        </div>
    )
}

export default Explore;