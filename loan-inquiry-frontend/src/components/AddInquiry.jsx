import React, { useState, useEffect } from "react";
import {
  newInquiry,
  updateInquiry,
  getInquiryById,
} from "../services/InquiryService";
import { useNavigate, useParams } from "react-router-dom";
import { toast } from "react-toastify";

const AddInquiry = () => {
  const [name, setName] = useState("");
  const [mobileNumber, setMobileNumber] = useState("");
  const [email, setEmail] = useState("");
  const [address, setAddress] = useState("");
  const [workType, setWorkType] = useState("");
  const [organizationName, setOrganizationName] = useState("");
  const [annualIncome, setAnnualIncome] = useState("");
  const [pastLoan, setPastLoan] = useState("");
  const [panCard, setPanCard] = useState("");

  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    if (id) {
      // get
      getInquiryById(id)
        .then((response) => {
          const data = response.data;
          setName(data.name);
          setMobileNumber(data.mobileNumber);
          setEmail(data.email);
          setAddress(data.address);
          setWorkType(data.workType);
          setOrganizationName(data.organizationName);
          setAnnualIncome(data.annualIncome);
          setPastLoan(data.pastLoan ? "yes" : "no");
          setPanCard(data.panCard);
        })
        .catch((error) => {
          console.error("Error fetching inquiry:", error);
          toast.error("Failed to load inquiry details.");
        });
    }
  }, [id]);

  const saveOrUpdateInquiry = (e) => {
    e.preventDefault();

    if (
      !name ||
      !mobileNumber ||
      !email ||
      !address ||
      !workType ||
      !organizationName ||
      !annualIncome ||
      !pastLoan ||
      !panCard
    ) {
      toast.error("Please fill all fields!");
      return;
    }

    const inquiry = {
      name,
      mobileNumber,
      email,
      address,
      workType,
      organizationName,
      annualIncome: parseFloat(annualIncome),
      pastLoan: pastLoan === "yes",
      panCard,
    };

    if (id) {
      // update
      updateInquiry(id, inquiry)
        .then(() => {
          toast.success("Inquiry Updated Successfully!");
          navigate("/inquiries");
        })
        .catch((error) => {
          console.error("Error updating inquiry:", error);
          toast.error("Failed to update inquiry. Please try again.");
        });
    } else {
      // Add
      newInquiry(inquiry)
        .then(() => {
          toast.success("Inquiry Added Successfully!");
          navigate("/inquiries");
        })
        .catch((error) => {
          console.error("Error adding inquiry:", error);
          toast.error("Failed to add inquiry. Please try again.");
        });
    }
  };

  return (
    <div className="container my-5 d-flex justify-content-center">
      <div className="col-md-8 border border-2 border-dark rounded-4 shadow-lg p-4 bg-white">
        <h2 className="text-center mb-4 text-secondary fw-bold">
          {id ? "Update Inquiry" : "Add Inquiry"}
        </h2>

        <form onSubmit={saveOrUpdateInquiry}>
          <div className="row">
            {/* LEFT SIDE */}
            <div className="col-md-6">
              <div className="mb-3">
                <label htmlFor="name" className="form-label">
                  Name
                </label>
                <input
                  type="text"
                  className="form-control"
                  id="name"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                  placeholder="Enter your name"
                />
              </div>

              <div className="mb-3">
                <label htmlFor="mobileNumber" className="form-label">
                  Mobile Number
                </label>
                <input
                  type="tel"
                  className="form-control"
                  id="mobileNumber"
                  value={mobileNumber}
                  onChange={(e) => setMobileNumber(e.target.value)}
                  placeholder="Enter your mobile number"
                />
              </div>

              <div className="mb-3">
                <label htmlFor="email" className="form-label">
                  Email
                </label>
                <input
                  type="email"
                  className="form-control"
                  id="email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  placeholder="Enter your email"
                />
              </div>

              <div className="mb-3">
                <label htmlFor="address" className="form-label">
                  Address
                </label>
                <input
                  type="text"
                  className="form-control"
                  id="address"
                  value={address}
                  onChange={(e) => setAddress(e.target.value)}
                  placeholder="Enter your address"
                />
              </div>
            </div>

            {/* RIGHT SIDE */}
            <div className="col-md-6">
              <div className="mb-3">
                <label htmlFor="workType" className="form-label">
                  Work Type
                </label>
                <input
                  type="text"
                  className="form-control"
                  id="workType"
                  value={workType}
                  onChange={(e) => setWorkType(e.target.value)}
                  placeholder="Enter your work type"
                />
              </div>

              <div className="mb-3">
                <label htmlFor="organizationName" className="form-label">
                  Organization Name
                </label>
                <input
                  type="text"
                  className="form-control"
                  id="organizationName"
                  value={organizationName}
                  onChange={(e) => setOrganizationName(e.target.value)}
                  placeholder="Enter your organization name"
                />
              </div>

              <div className="mb-3">
                <label htmlFor="annualIncome" className="form-label">
                  Annual Income
                </label>
                <input
                  type="number"
                  className="form-control"
                  id="annualIncome"
                  value={annualIncome}
                  onChange={(e) => setAnnualIncome(e.target.value)}
                  placeholder="Enter your annual income"
                />
              </div>

              <div className="mb-3">
                <label className="form-label d-block">Past Loan</label>
                <div className="form-check form-check-inline">
                  <input
                    type="radio"
                    className="form-check-input"
                    id="pastLoanYes"
                    name="pastLoan"
                    value="yes"
                    checked={pastLoan === "yes"}
                    onChange={(e) => setPastLoan(e.target.value)}
                  />
                  <label htmlFor="pastLoanYes" className="form-check-label">
                    Yes
                  </label>
                </div>

                <div className="form-check form-check-inline">
                  <input
                    type="radio"
                    className="form-check-input"
                    id="pastLoanNo"
                    name="pastLoan"
                    value="no"
                    checked={pastLoan === "no"}
                    onChange={(e) => setPastLoan(e.target.value)}
                  />
                  <label htmlFor="pastLoanNo" className="form-check-label">
                    No
                  </label>
                </div>
              </div>

              <div className="mb-3">
                <label htmlFor="panCard" className="form-label">
                  PAN Card
                </label>
                <input
                  type="text"
                  className="form-control"
                  id="panCard"
                  value={panCard}
                  onChange={(e) => setPanCard(e.target.value)}
                  placeholder="Enter your PAN card number"
                />
              </div>
            </div>
          </div>

          <div className="text-center mt-3">
            <button type="submit" className="btn btn-primary px-5 fw-semibold">
              {id ? "Update Inquiry" : "Add Inquiry"}
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default AddInquiry;
