package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Retrieve individual form fields
        String regNo = request.getParameter("regNo");
        String studentName = request.getParameter("studentName");
        String department = request.getParameter("department");
        String attendanceStr = request.getParameter("attendance");
        
        // Retrieve multiple marks via getParameterValues()
        String[] marksArray = request.getParameterValues("subjectMarks");

        // 2. Type Conversion and Calculations
        double attendance = Double.parseDouble(attendanceStr);
        
        int totalMarks = 0;
        boolean hasMinimumMarks = true; 
        int minimumRequired = 45; // Minimum passing mark per subject

        if (marksArray != null) {
            for (String markStr : marksArray) {
                int mark = Integer.parseInt(markStr);
                totalMarks += mark;
                
                // Track if student failed any individual subject
                if (mark < minimumRequired) {
                    hasMinimumMarks = false;
                }
            }
        }

        double average = totalMarks / 5.0;

        // 3. Assign Grade based on overall average
        String grade;
        if (average >= 90) grade = "O (Outstanding)";
        else if (average >= 80) grade = "A+ (Excellent)";
        else if (average >= 70) grade = "A (Very Good)";
        else if (average >= 60) grade = "B (Good)";
        else if (average >= 50) grade = "C (Satisfactory)";
        else grade = "RA (Re-Appearance Required)";

        // 4. Check Exam Eligibility based on attendance (e.g., minimum 75%)
        boolean isEligible = attendance >= 75.0;
        String eligibilityStatus = isEligible ? "ELIGIBLE" : "NOT ELIGIBLE (Shortage of Attendance)";

        // 5. Determine overall Pass/Fail outcome
        String finalResult;
        String resultColor;
        
        if (!isEligible) {
            finalResult = "WHITHHELD (Ineligible)";
            resultColor = "#ff9800"; // Orange
        } else if (hasMinimumMarks && average >= 50) {
            finalResult = "PASSED";
            resultColor = "#2ec4b6"; // Green
        } else {
            finalResult = "FAILED";
            resultColor = "#e63946"; // Red
        }

        // 6. Generate Dynamic HTML Output Layout
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Examination Result</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f7f6; margin: 40px; }");
        out.println(".result-card { max-width: 600px; background: white; padding: 25px; border-radius: 8px; box-shadow: 0px 0px 15px rgba(0,0,0,0.1); margin: auto; }");
        out.println("h2 { text-align: center; color: #333; border-bottom: 2px solid #ddd; padding-bottom: 10px; }");
        out.println("table { width: 100%; border-collapse: collapse; margin-top: 15px; }");
        out.println("th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }");
        out.println("th { background-color: #f8f9fa; font-weight: bold; width: 40%; }");
        out.println(".status-badge { font-weight: bold; color: white; padding: 5px 10px; border-radius: 4px; display: inline-block; background-color: " + resultColor + "; }");
        out.println(".back-btn { display: block; text-align: center; margin-top: 20px; text-decoration: none; color: #007bff; font-weight: bold; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<div class='result-card'>");
        out.println("<h2>Student Examination Report Card</h2>");
        out.println("<table>");
        out.println("<tr><th>Register Number</th><td>" + regNo + "</td></tr>");
        out.println("<tr><th>Student Name</th><td>" + studentName + "</td></tr>");
        out.println("<tr><th>Department</th><td>" + department + "</td></tr>");
        
        // Loop back through marks array to print subject-specific stats
        if (marksArray != null) {
            for (int i = 0; i < marksArray.length; i++) {
                out.println("<tr><th>Subject " + (i + 1) + " Mark</th><td>" + marksArray[i] + "</td></tr>");
            }
        }
        
        out.println("<tr><th>Total Marks</th><td>" + totalMarks + " / 500</td></tr>");
        out.println("<tr><th>Average Mark</th><td>" + String.format("%.2f", average) + "</td></tr>");
        out.println("<tr><th>Attendance</th><td>" + attendance + "% (" + eligibilityStatus + ")</td></tr>");
        out.println("<tr><th>Grade Earned</th><td>" + grade + "</td></tr>");
        out.println("<tr><th>Final Status</th><td><span class='status-badge'>" + finalResult + "</span></td></tr>");
        out.println("</table>");
        out.println("<a href='index.html' class='back-btn'>&larr; Process Another Result</a>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}
