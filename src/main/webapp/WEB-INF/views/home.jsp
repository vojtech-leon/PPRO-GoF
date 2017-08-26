<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>     
<%@ include file="../tiles/layouts/taglibsAll.jsp"%>

<h2>Vítejte na stránkách ke hře Game of Flags!</h2>
<p>Najdete zde veškeré informace, které jsou dostupné o dané hře. </p>

<p> Počet hráčů: 
<c:set var="countPlayers" value="0" scope="page" />
				<c:forEach items="${listOfPlayers}" var="players">
				<c:set var="countPlayers" value="${countPlayers + 1}" scope="page" />
				</c:forEach>
 			 ${countPlayers}
</p>
<p> Počet vlajek: 
<c:set var="countFlags" value="0" scope="page" />
				<c:forEach items="${listOfFlags}" var="flags">
				<c:set var="countFlags" value="${countFlags + 1}" scope="page" />
				</c:forEach>
 			 ${countFlags}
</p>

<c:set var="countFlagsRed" value="0" scope="page" />
<c:set var="countFlagsBlue" value="0" scope="page" />
				<c:forEach items="${listOfFlags}" var="flags">
				<c:if test="${flags.fraction.name == 'Red' }">	
					<c:set var="countFlagsRed" value="${countFlagsRed + 1}" scope="page" />
				</c:if>
				<c:if test="${flags.fraction.name == 'Blue' }">
					<c:set var="countFlagsBlue" value="${countFlagsBlue + 1}" scope="page" />
				</c:if>
				</c:forEach>
				
<c:set var="countPlayersRed" value="0" scope="page" />
<c:set var="countPlayersBlue" value="0" scope="page" />
				<c:forEach items="${listOfPlayers}" var="players">
				<c:if test="${players.fraction.name == 'Red' }">	
					<c:set var="countPlayersRed" value="${countPlayersRed + 1}" scope="page" />
				</c:if>
				<c:if test="${players.fraction.name == 'Blue' }">
					<c:set var="countPlayersBlue" value="${countPlayersBlue + 1}" scope="page" />
				</c:if>
				</c:forEach>

<div class="row">
<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6" id="chart-flags"></div>
<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6" id="chart-players"></div> 
</div>

<script>
      var chartData ={
    		  type: 'pie',
    		  title:{
    		        text:'Vlastnictví vlajek'
    		    },
    		  series: [
    		  {
    		    values: [${countFlagsBlue}]
    		  },
    		  {
    		    values: [${countFlagsRed}]
    		  }
    		  ]
        };
      zingchart.render({
        id: 'chart-flags',
        data: chartData
      });
      
      var chartData2 ={
    		  type: 'pie',
    		  title:{
  		        text:'Rozdělení hráčů'
  		    	},
    		  series: [
    		  {
    		    values: [${countPlayersBlue}]
    		  },
    		  {
    		    values: [${countPlayersRed}]
    		  }
    		  ]
        };
      zingchart.render({
        id: 'chart-players',
        data: chartData2
      });
    </script>
   
