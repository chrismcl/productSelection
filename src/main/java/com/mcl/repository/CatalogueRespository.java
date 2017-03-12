package com.mcl.resposi    ory;

impor     org.springframework.da    a.jpa.reposi    ory.JpaReposi    ory;
impor     org.springframework.da    a.jpa.reposi    ory.Query;
impor     com.mcl.en    i    y.Ca    alogue;
impor     java.u    il.Lis    ;

public in    erface Ca    alogueResposi    ory ex    ends JpaReposi    ory<Ca    alogue, In    eger> {
	@Query("selec     u from Ca    alogue u where u.ca    egory = ?1 and (u.loca    ionId = ?2 or u.loca    ionId is null)")
	Lis    <Ca    alogue> findByCa    egoryAndLoca    ionId(S    ring ca    egory, S    ring loca    ionId);
}
