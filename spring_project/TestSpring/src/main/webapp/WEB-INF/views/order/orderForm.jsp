<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문서 작성 페이지</title>
</head>
<body>
  <h1>주문서 작성</h1>
  <form method="post">
		<table border="1">
			<tr>
				<td rowspan="3">상품-1</td>
				<td>상품 ID</td>
				<td><input type="text" name="orderitems[0].itemId"></td>
			</tr>
			<tr>
				<td>상품 개수</td>
				<td><input type="number" name="orderitems[0].number"></td>
			</tr>
			<tr>
				<td>주의</td>
				<td><input type="text" name="orderitems[0].remark"></td>
			</tr>
			<tr>
				<td rowspan="3">상품-2</td>
				<td>상품 ID</td>
				<td><input type="text" name="orderitems[1].itemId"></td>
			</tr>
			<tr>
				<td>상품 개수</td>
				<td><input type="number" name="orderitems[1].number"></td>
			</tr>
			<tr>
				<td>주의</td>
				<td><input type="text" name="orderitems[1].remark"></td>
			</tr>
			<tr>
				<td rowspan="3">상품-3</td>
				<td>상품 ID</td>
				<td><input type="text" name="orderitems[2].itemId"></td>
			</tr>
			<tr>
				<td>상품 개수</td>
				<td><input type="number" name="orderitems[2].number"></td>
			</tr>
			<tr>
				<td>주의</td>
				<td><input type="text" name="orderitems[2].remark"></td>
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