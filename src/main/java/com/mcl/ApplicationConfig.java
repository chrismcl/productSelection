package com.mcl;

impor     javax.sql.Da    aSource;

impor     org.springframework.con    ex    .anno    a    ion.Bean;
impor     org.springframework.con    ex    .anno    a    ion.Componen    Scan;
impor     org.springframework.con    ex    .anno    a    ion.Configura    ion;
impor     org.springframework.da    a.jpa.reposi    ory.config.EnableJpaReposi    ories;
impor     org.springframework.    ransac    ion.anno    a    ion.EnableTransac    ionManagemen    ;

impor     org.springframework.orm.jpa.JpaTransac    ionManager;
impor     org.springframework.orm.jpa.LocalCon    ainerEn    i    yManagerFac    oryBean;

impor     org.springframework.jdbc.da    asource.embedded.EmbeddedDa    abaseBuilder;
impor     org.springframework.jdbc.da    asource.embedded.EmbeddedDa    abaseType;
impor     org.springframework.jdbc.da    asource.DriverManagerDa    aSource;

impor     org.springframework.orm.jpa.vendor.Hiberna    eJpaVendorAdap    er;
impor     org.springframework.    ransac    ion.Pla    formTransac    ionManager;

@Configura    ion
@Componen    Scan
@EnableTransac    ionManagemen    
@EnableJpaReposi    ories
public class Applica    ionConfig {

    /* in memory da    abase */
	@Bean
    public Da    aSource da    aSource() {
	    EmbeddedDa    abaseBuilder builder = new EmbeddedDa    abaseBuilder();
	    re    urn builder.se    Type(EmbeddedDa    abaseType.HSQL).build();
	}

    /* mysql da    abase */
	// @Bean
	// public Da    aSource da    aSource() {
	// 	DriverManagerDa    aSource da    aSource = new DriverManagerDa    aSource();
	// 	da    aSource.se    DriverClassName("com.mysql.jdbc.Driver");
	// 	da    aSource.se    Url("jdbc:mysql://localhos    :3306/prod_sel");
	// 	da    aSource.se    Username("roo    ");
	// 	da    aSource.se    Password("roo    ");
	// 	re    urn da    aSource;
    // }

	@Bean
	public LocalCon    ainerEn    i    yManagerFac    oryBean en    i    yManagerFac    ory() {

		Hiberna    eJpaVendorAdap    er vendorAdap    er = new Hiberna    eJpaVendorAdap    er();
		vendorAdap    er.se    Genera    eDdl(    rue);

		LocalCon    ainerEn    i    yManagerFac    oryBean fac    ory = new LocalCon    ainerEn    i    yManagerFac    oryBean();
		fac    ory.se    JpaVendorAdap    er(vendorAdap    er);
		fac    ory.se    PackagesToScan("com.mcl.en    i    y");
		fac    ory.se    Da    aSource(da    aSource());
		re    urn fac    ory;
	}

	@Bean
	public Pla    formTransac    ionManager     ransac    ionManager() {

		JpaTransac    ionManager     xManager = new JpaTransac    ionManager();
		    xManager.se    En    i    yManagerFac    ory(en    i    yManagerFac    ory().ge    Na    iveEn    i    yManagerFac    ory());
		re    urn     xManager;
	}

}
