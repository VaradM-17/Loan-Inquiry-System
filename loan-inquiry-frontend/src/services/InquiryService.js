import axios from "axios";

const baseUrl = "http://localhost:8080/api/inquiries";

export const fetchInquiries = () => axios.get(baseUrl);
export const newInquiry = (inquiry) => axios.post(`${baseUrl}/inquiry`, inquiry);
export const getInquiryById = (id) => axios.get(`${baseUrl}/${id}`);
export const updateInquiry = (id, inquiry) => axios.put(`${baseUrl}/${id}`, inquiry);
export const removeInquiry = (id) => axios.delete(`${baseUrl}/${id}`);
