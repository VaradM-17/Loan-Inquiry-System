import React, { useEffect, useState } from "react";
import { fetchInquiries, removeInquiry } from "../services/InquiryService";
import { useNavigate } from "react-router-dom";
import { FaEdit, FaTrashAlt } from "react-icons/fa";
import { toast } from "react-toastify";

const Inquiries = () => {
  const [inquiries, setInquiries] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    loadInquiries();
  }, []);

  const loadInquiries = () => {
    fetchInquiries()
      .then((response) => setInquiries(response.data))
      .catch((error) => console.error("Error fetching inquiries:", error));
  };

  function addInquiry() {
    navigate("/add-inquiry");
  }

  function updateInquiry(id) {
    navigate(`/update-inquiry/${id}`);
  }

  function deleteInquiry(id) {
    if (window.confirm("Are you sure you want to delete this inquiry?")) {
      removeInquiry(id)
        .then(() => {
          toast.success("Inquiry deleted successfully!");
          loadInquiries();
        })
        .catch((error) => {
          console.error("Error deleting inquiry:", error);
          toast.error("Failed to delete inquiry!");
        });
    }
  }

  return (
    <div className="container-fluid mt-5">
      <h2 className="text-center mb-4 text-secondary fw-bold">
        Loan Inquiries
      </h2>
      <button className="btn btn-primary mb-3 ms-4" onClick={addInquiry}>
        Add Inquiry
      </button>

      <div className="table-responsive shadow rounded">
        <table className="table table-hover table-bordered align-middle">
          <thead className="table-secondary text-center">
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Mobile Number</th>
              <th>Email</th>
              <th>Address</th>
              <th>Work Type</th>
              <th>Organization</th>
              <th>Annual Income</th>
              <th>Past Loan</th>
              <th>PAN Card</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {inquiries.map((inquiry) => (
              <tr className="text-center" key={inquiry.id}>
                <td>{inquiry.id}</td>
                <td>{inquiry.name}</td>
                <td>{inquiry.mobileNumber}</td>
                <td>{inquiry.email}</td>
                <td>{inquiry.address}</td>
                <td>{inquiry.workType}</td>
                <td>{inquiry.organizationName}</td>
                <td>{inquiry.annualIncome}</td>
                <td>{inquiry.pastLoan ? "Yes" : "No"}</td>
                <td>{inquiry.panCard}</td>
                <td>
                  <button
                    className="btn btn-sm btn-info me-2"
                    onClick={() => updateInquiry(inquiry.id)}
                  >
                    <FaEdit />
                  </button>
                  <button
                    className="btn btn-sm btn-danger"
                    onClick={() => deleteInquiry(inquiry.id)}
                  >
                    <FaTrashAlt />
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Inquiries;
