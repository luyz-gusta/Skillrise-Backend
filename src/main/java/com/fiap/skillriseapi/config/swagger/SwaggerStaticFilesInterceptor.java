package com.fiap.skillriseapi.config.swagger;

import jakarta.servlet.http.HttpServletRequest;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springdoc.core.properties.SwaggerUiOAuthProperties;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springdoc.webmvc.ui.SwaggerIndexPageTransformer;
import org.springdoc.webmvc.ui.SwaggerWelcomeCommon;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.resource.ResourceTransformerChain;
import org.springframework.web.servlet.resource.TransformedResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class SwaggerStaticFilesInterceptor extends SwaggerIndexPageTransformer {

    public SwaggerStaticFilesInterceptor(
            SwaggerUiConfigProperties swaggerUiConfig,
            SwaggerUiOAuthProperties swaggerUiOAuthProperties,
            SwaggerWelcomeCommon swaggerWelcomeCommon,
            ObjectMapperProvider objectMapperProvider
    ) {
        super(swaggerUiConfig, swaggerUiOAuthProperties, swaggerWelcomeCommon, objectMapperProvider);
    }


    @Override
    public Resource transform(HttpServletRequest request, Resource resource, ResourceTransformerChain transformer) throws IOException {

        if (resource.toString().contains("index.css")) {
            final InputStream is = resource.getInputStream();
            final InputStreamReader isr = new InputStreamReader(is);
            try (BufferedReader br = new BufferedReader(isr)) {
                String css = br.lines().collect(Collectors.joining());

                css += """
                        #theme-switcher input[type=checkbox]{display:none}#theme-switcher{position:absolute;top:120px;display:inline-block;width:50px;height:25px;background-color:#000;border-radius:50px;cursor:pointer;transition:background-color .3s;padding:0}#theme-switcher #slider{position:absolute;top:3.1px;left:3px;width:19px;height:19px;background-color:#fff;border-radius:50%;transition:transform .3s;z-index:999}#theme-switcher input[type=checkbox]:checked+#slider{transform:translateX(25px)}#theme-switcher::after,#theme-switcher::before{position:absolute;top:3px;font-size:14px;transition:opacity .3s}#theme-switcher::after{content:"🌙️";right:3px}#theme-switcher::before{content:"☀️";left:3px}
                        """;

                final byte[] transformedContent = css.getBytes();
                return new TransformedResource(resource, transformedContent);
            }
        }

        if (resource.toString().contains("index.html")) {
            final InputStream is = resource.getInputStream();
            final InputStreamReader isr = new InputStreamReader(is);
            try (BufferedReader br = new BufferedReader(isr)) {
                String html = br.lines().collect(Collectors.joining());
                html = html.replace("Swagger UI", "DASA API Definition");

                html = html.replace("<meta charset=\"UTF-8\">",
                        """
                                <meta charset="UTF-8">
                                <script>
                                    const observerCallback=(e,t)=>{for(let r of e)if("attributes"===r.type&&"class"===r.attributeName){let l=r.target;if("info"==l.className&&l.querySelector("hgroup")){let i=document.createElement("div");i.style.display="flex",i.style.justifyContent="end",i.innerHTML=`
                                      <label id="theme-switcher">
                                          <input type="checkbox"/>
                                          <span id="slider"/>
                                      </label>`,l.appendChild(i);
                                      let n=document.querySelector("#theme-switcher input"),a=document.querySelector("#theme-switcher"),c=document.querySelector("#custom-style");c.disabled=!0,n.addEventListener("change",function(){n.checked?(c.disabled=!1,a.style.backgroundColor="#ffe4c0"):(c.disabled=!0,a.style.backgroundColor="#000")}),t.disconnect()}}},observer=new MutationObserver(observerCallback),config={attributes:!0,attributeFilter:["class"]},originalCreateElement=document.createElement;document.createElement=function(e){let t=originalCreateElement.call(document,e);
                                      return observer.observe(t,config),t},document.currentScript.parentNode.removeChild(document.currentScript);
                                </script>
                                """);

                html = html.replace("<meta charset=\"UTF-8\">",
                        """
                                <meta charset="UTF-8">
                                <style id="custom-style">
                                    .btn-done,.opblock-body thead tr td,.opblock-body thead tr th,.opblock-tag{border-color:rgb(255 255 255 / 50%)!important}.opblock-section-header button,input,select{border-color:#b3b3b3!important}input{background-color:#5a5a5a!important;color:#fff!important}select{background-color:#868686!important;color:#ececec!important}svg{fill:#ECECEC!important}.swagger-container,html{background-color:#565656!important}.url,strong{color:#86a7ff!important}.btn-clear,.btn-done,.col_header,.opblock-section-header button,.opblock-tag-section .opblock-summary-description,.opblock-tag-section .opblock-summary-path,.parameter__name,.scheme-container,.model-box [class*=title],.tabitem,h1,h2,h3,h4,h5,h6,i,label,p,small,td{color:#ececec!important}.scheme-container{background-color:#6a6a6a!important}.auth-wrapper svg{fill:#49cc90!important}.close-modal svg{fill:black!important}.parameter__type{color:#c99af1!important}.parameter__in,.prop-format{color:#b9b9b9!important}.tabitem:after{background-color:#ececec!important}.modal-ux-inner,.opblock-section-header{background-color:#6c6f6e!important}.model-box [class*=keyword],.models [class*=keyword]{color:#979797!important}.models,.models [class*=title],.models button{color:#ececec!important;background-color:#525252!important}
                                </style>
                                """
                );

                final byte[] transformedContent = html.getBytes();
                return new TransformedResource(resource, transformedContent);
            }
        }
        return super.transform(request, resource, transformer);
    }
}
