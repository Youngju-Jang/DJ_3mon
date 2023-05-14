<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- fn:contains(string, sbustring)

string이 substring을 포함하면 return true 반환 -->
${fn:contains('abc', 'a')} 


${fn:containsIgnoreCase('aBc', 'b')}

<!-- 대소문자 관계없이 string이 substring을 포함하면 return true 반환 -->

${fn:startsWith('bit', 'b')}

<!-- string이 prefix로 시작하면 return True -->

${ fn:endsWith('abc', 'a')}

<!-- string이 suffix로 끝나면 return True -->

${fn:escapeXml('<b>hiBit</b>')}
${'<b>hiBit</b>'}
<!-- stting에 XML과 HTML에서 < >& ' " 문자들이 있으면, XML엔티티 코드로 바꿔준뒤 문자열 반환 -->

${fn:indexOf('string', 's')}

<!-- string에서 substring이 처음으로 나타나는 인덱스 반환 -->

${fn:split('ab#cd#ef#gh', '#')}

<!-- string내의 문자열 separetor에 따라 나누어서 배열로 구성해서 반환 -->
${fn:length(fn:split('ab#cd#ef#gh', '#'))}

<c:forEach var="i" items="${fn:split('ab#cd#ef#gh', '#') }" varStatus="cnt">
    <c:choose>
        <c:when test="${fn:length(fn:split('ab#cd#ef#gh', '#'))eq cnt.count }">
           ${i}
        </c:when>
          <c:otherwise>
          ${i},
          </c:otherwise>
    </c:choose>
</c:forEach>
  ${fn:join(fn:split('ab#cd#ef#gh', '#'),'-')}
  
  ${fn:replace('a b c', ' ', '')}

 <!-- string내에 있는 before 문자열을 after 문자열로 모두 변경해서 반환 -->
  ${fn:substring('abcd', 1, 2)}
  ${fn:substring('abcd', 1,4)}
<!-- string에서 begin인덱스에서 시작해서 end인덱스에 끝나는 부분의 문자열 반환 -->

${fn:substringAfter('abcd', 'b')}
<!-- string에서 substring이 나타나는 이후의 문자열 반환 -->

${fn:substringBefore('abcd', 'b')}

<!-- string에서 substring이 나타나는 이전의 문자열 반환 -->

${fn:toLowerCase('String')}

<!-- string을 모두 소문자로 변경 후 리턴 -->

${fn:toUpperCase('string')}
<!-- string을 모두 대문자로 변경 후 리턴 -->

${fn:trim('str ing ') eq 'string'}

${fn:replace(fn:trim('str ing '),' ','') eq 'string'}
<!-- string앞뒤의 공백을 모두 제거한 후 반환 -->

</body>
</html>





