<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../tiles/layouts/taglibsAll.jsp"%>

	<h3>Detail scanu</h3>

<div>
	<!-- obal detailu veci-->
	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<dl>
				<dt>Hráč:</dt>
				<dd>${scanDetails.player.nickname}</dd>
				<dt>Frakce:</dt>
				<dd>${scanDetails.fraction.name}</dd>
				<dt>Vlajka:</dt>
				<dd>${scanDetails.flag.name}</dd>
				<dt>Oscanováno:</dt>
				<dd>
					<fmt:formatDate value="${scanDetails.scanWhen}"
						pattern="dd.MM.yyyy HH:mm:ss" />
				</dd>
			</dl>
		</div>
	</div>
    <hr/>
    <h4>Otisk:</h4>
	<div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" id="fingerprint">
             ${scanDetails.fingerprint}
        </div>
    </div>
</div>
