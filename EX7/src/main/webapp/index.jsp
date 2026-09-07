<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Inventory Entry Form</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f7f6; margin: 40px; }
        .form-container { max-width: 550px; background: white; padding: 25px; border-radius: 8px; box-shadow: 0px 0px 12px rgba(0,0,0,0.1); margin: auto; }
        h2 { text-align: center; color: #333; margin-bottom: 20px; border-bottom: 2px solid #333; padding-bottom: 10px; }
        table { width: 100%; border-collapse: collapse; }
        td { padding: 10px; vertical-align: middle; }
        td:first-child { width: 40%; font-weight: bold; color: #444; }
        input { width: 100%; padding: 8px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
        .btn-submit { width: 100%; background-color: #2ec4b6; color: white; border: none; padding: 12px; margin-top: 20px; font-size: 16px; border-radius: 4px; cursor: pointer; font-weight: bold; }
        .btn-submit:hover { background-color: #209e93; }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Product Inventory Form</h2>
    <form action="server.jsp" method="POST">
        <table>
            <tr>
                <td><label for="productId">Product ID:</label></td>
                <td><input type="text" id="productId" name="productId" required></td>
            </tr>
            <tr>
                <td><label for="productName">Product Name:</label></td>
                <td><input type="text" id="productName" name="productName" required></td>
            </tr>
            <tr>
                <td><label for="unitPrice">Unit Price (₹):</label></td>
                <td><input type="number" id="unitPrice" name="unitPrice" min="0" step="0.01" required></td>
            </tr>
            <tr>
                <td><label for="quantity">Quantity:</label></td>
                <td><input type="number" id="quantity" name="quantity" min="0" required></td>
            </tr>
            <tr>
                <td><label for="supplierName">Supplier Name:</label></td>
                <td><input type="text" id="supplierName" name="supplierName" required></td>
            </tr>
        </table>
        
        <button type="submit" class="btn-submit">Submit to Inventory</button>
    </form>
</div>

</body>
</html>
