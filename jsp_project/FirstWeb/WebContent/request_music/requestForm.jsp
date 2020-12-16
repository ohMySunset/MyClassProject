<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Form</title>

<style>
.question {
	font-weight: bold;
}

.sub{
 text-align: center;
}

</style>
</head>
<body>
    <h3>[사용자 음악 취향 조사]</h3>
	<h3> What is your Music taste♬?</h3>
	<hr>

	<form action="requestResult.jsp">
		<table>
			<tr>
				<td class="question">당신의 나이는?<br></td>
				<td><input type="text" name="age"
					style="width: 40px;">세</td>
			</tr>
			<tr>
				<td class="question">당신의 성별은?</td>
				<td>
				<select name="sex">
					<option value="female">여성</option>
					<option value="male">남성</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="question">선호하는 음악의 연도는?</td>
				<td>
				<input type="checkbox" name="year" value="70~80년도">70~80년도<br>
				<input type="checkbox" name="year" value="80~90년도">80~90년도<br>
				<input type="checkbox" name="year" value="90~00년도">90~00년도<br>
				<input type="checkbox" name="year" value="2000년대">2000년대
				</td>
			</tr>
			<tr>
				<td class="question">선호하는 음악 장르는?</td>
				<td>
				<input type="checkbox" name="genre" value="Pop">Pop<br>
				<input type="checkbox" name="genre" value="Jazz">Jazz<br>
				<input type="checkbox" name="genre" value="Hip-hop">Hip-hop<br>
				<input type="checkbox" name="genre" value="Ballad">Ballad<br>
				<input type="checkbox" name="genre" value="Rock">Rock
				</td>
			</tr>
			<tr>
			<td colspan="2" class="sub">
			<input type="submit" value="저장">
			<input type="reset" value="취소">
			</td>
			<td></td>
			</tr>
		</table>

	</form>
</body>
</html>