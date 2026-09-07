<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Inventory Report</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f7f6; margin: 40px; }
        .report-container { max-width: 650px; background: white; padding: 25px; border-radius: 8px; box-shadow: 0px 0px 15px rgba(0,0,0,0.1); margin: auto; }
        h2 { text-align: center; color: #333; border-bottom: 2px solid #ddd; padding-bottom: 10px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px; text-align: left; border: 1px solid #ddd; }
        th { background-color: #f8f9fa; font-weight: bold; width: 45%; }
        .status-badge { font-weight: bold; color: white; padding: 5px 10px; border-radius: 4px; display: inline-block; }
        .back-link { display: block; text-align: center; margin-top: 25px; text-decoration: none; color: #007bff; font-weight: bold; }
        .back-link:hover { text-decoration: underline; }
    </style>
</head>
<body>

<div class="report-container">
    <h2>Product Inventory Report</h2>
    
    <%
        // 1. Retrieve the submitted product details using request.getParameter()
        String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String unitPriceStr = request.getParameter("unitPrice");
        String quantityStr = request.getParameter("quantity");
        String supplierName = request.getParameter("supplierName");
        
        // Variables for calculation processing
        double unitPrice = 0.0;
        int quantity = 0;
        double totalInventoryValue = 0.0;
        String stockStatus = "";
        String statusColor = "";
        
        // 2. Type Conversion & Safeguards
        if (unitPriceStr != null && quantityStr != null) {
            unitPrice = Double.parseDouble(unitPriceStr);
            quantity = Integer.parseInt(quantityStr);
            
            // Calculate Total Inventory Value
            totalInventoryValue = unitPrice * quantity;
        }
        
        // 3. Conditional Assessment logic for Stock Status
        if (quantity == 0) {
            stockStatus = "Out of Stock";
            statusColor = "#e63946"; // Red
        } else if (quantity < 10) {
            stockStatus = "Low Stock";
            statusColor = "#ff9800"; // Orange
        } else {
            stockStatus = "In Stock";
            statusColor = "#2ec4b6"; // Green
        }
    %>
    
    <!-- Displaying the Complete Report inside a Formatted HTML Table -->
    <table>
        <tr>
            <th>Product ID</th>
            <td><%= productId %></td>
        </tr>
        <tr>
            <th>Product Name</th>
            <td><%= productName %></td>
        </tr>
        <tr>
            <th>Unit Price</th>
            <td>₹<%= String.format("%.2f", unitPrice) %></td>
        </tr>
        <tr>
            <th>Available Quantity</th>
            <td><%= quantity %> units</td>
        </tr>
        <tr>
            <th>Total Inventory Value</th>
            <td><strong>₹<%= String.format("%.2f", totalInventoryValue) %></strong></td>
        </tr>
        <tr>
            <th>Supplier Name</th>
            <td><%= supplierName %></td>
        </tr>
        <tr>
            <th>Stock Status</th>
            <td>
                <span class="status-badge" style="background-color: <%= statusColor %>;">
                    <%= stockStatus %>
                </span>
            </td>
        </tr>
    </table>
    
    <a href="index.jsp" class="back-link">&larr; Enter Another Product</a>
</div>

</body>
</html>
