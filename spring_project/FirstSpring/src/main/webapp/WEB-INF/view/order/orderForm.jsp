<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문</title>
</head>
<body>

	<h1>주문 양식</h1>
	<form method="post">
		<table border="1">
			<tr>
				<td rowspan="3">상품-1</td>
				<td>상품 ID</td>
				<td><input type="text" name="orderItems[0].id"></td>
			</tr>
			<tr>
				<td>상품 개수</td>
				<td><input type="number" name="orderItems[0].number"></td>
			</tr>
			<tr>
				<td>주의</td>
				<td><input type="text" name="orderItems[0].remark"></td>
			</tr>
			<tr>
				<td rowspan="3">상품-2</td>
				<td>상품 ID</td>
				<td><input type="text" name="orderItems[1].id"></td>
			</tr>
			<tr>
				<td>상품 개수</td>
				<td><input type="number" name="orderItems[1].number"></td>
			</tr>
			<tr>
				<td>주의</td>
				<td><input type="text" name="orderItems[1].remark"></td>
			</tr>
			<tr>
				<td rowspan="3">상품-3</td>
				<td>상품 ID</td>
				<td><input type="text" name="orderItems[2].id"></td>
			</tr>
			<tr>
				<td>상품 개수</td>
				<td><input type="number" name="orderItems[2].number"></td>
			</tr>
			<tr>
				<td>주의</td>
				<td><input type="text" name="orderItems[2].remark"></td>
			</tr>
			<tr>
				<td rowspan="3">배송지</td>
				<td>우편번호</td>
				<td><input type="text" name="address.zipcode"></td>
			</tr>
			<tr>
				<td>주소1</td>
				<td><input type="text" name="address.address1"></td>
			</tr>
			<tr>
				<td>주소2</td>
				<td><input type="text" name="address.address2"></td>
			</tr>
			<tr>
			<td colspan="3"><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>