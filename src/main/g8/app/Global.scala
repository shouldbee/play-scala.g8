import com.googlecode.htmlcompressor.compressor.HtmlCompressor
import com.mohiva.play.htmlcompressor.HTMLCompressorFilter
import com.mohiva.play.xmlcompressor.XMLCompressorFilter
import play.api.Play
import play.api.Play.current
import play.api.mvc.WithFilters
import play.filters.headers.{ SecurityHeadersFilter, DefaultSecurityHeadersConfig }

object Global extends WithFilters(
  new HTMLCompressorFilter({
    val compressor = new HtmlCompressor()
    if (Play.isDev) {
      compressor.setPreserveLineBreaks(true)
    }
    compressor.setRemoveComments(true)
    compressor.setRemoveIntertagSpaces(true)
    compressor.setRemoveHttpProtocol(true)
    compressor.setRemoveHttpsProtocol(true)
    compressor
  }),
  XMLCompressorFilter(),
  SecurityHeadersFilter(
    DefaultSecurityHeadersConfig(
      frameOptions = Some("DENY"), // sets X-Frame-Options
      xssProtection = Some("1; mode=block"), // sets X-XSS-Protection
      contentTypeOptions = Some("nosniff"), // sets X-Content-Type-Options
      permittedCrossDomainPolicies = Some("master-only"), // sets X-Permitted-Cross-Domain-Policies
      contentSecurityPolicy = None // sets Content-Security-Policy
    )
  )
)
