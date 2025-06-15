import './CustomerForm.css';

const CustomerForm = ({customerName, phoneNumber, setPhoneNumber, setCustomerName}) => {
    return (
        <div className="p-3">
            <div className="mb-3">
                <div className="d-flex align-items-center gap-2">
                    <label htmlFor="customerName" className="col-4">Customer Name</label>
                    <input type="text" className="form-control form-control-sm" id="customerName" onChange={(e) => setCustomerName(e.target.value)} value={customerName} required />
                </div>
            </div>
            <div className="mb-3">
                <div className="d-flex align-items-center gap-2">
                    <label htmlFor="phoneNumber" className="col-4">Phone number</label>
                    <input type="text" className="form-control form-control-sm" id="phoneNumber" onChange={(e) => setPhoneNumber(e.target.value)} value={phoneNumber} required />
                </div>
            </div>
        </div>
    )
}

export default CustomerForm;