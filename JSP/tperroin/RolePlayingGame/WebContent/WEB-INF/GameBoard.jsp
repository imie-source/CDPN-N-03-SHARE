<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./styles/style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GameBoard</title>
</head>
<body>

	<jsp:include page="Header.jsp" />

	<div>
		<form action="GameBoardController" method="post">
			<input type="submit" name="movement" value="TOP" /> <input
				type="submit" name="movement" value="LEFT" /> <input type="submit"
				name="movement" value="RIGHT" /> <input type="submit"
				name="movement" value="DOWN" />
		</form>
		<table>
			<c:forEach var="xs" items="${personnageConnected.gameBoard.xs}"
				varStatus="loopStatusX">
				<tr>
					<c:forEach var="ys" items="${personnageConnected.gameBoard.ys}"
						varStatus="loopStatusY">
						<c:choose>
							<c:when
								test="${personnageConnected.currentCell.num == (loopStatusX.index * 10 + loopStatusY.index)}">
								<c:choose>
									<c:when test="${movement == null}">
										<td class="DOWN"></td>
									</c:when>
									<c:otherwise>
										<td class="${movement}"></td>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<td class="sol"></td>
							</c:otherwise>
						</c:choose>

					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>