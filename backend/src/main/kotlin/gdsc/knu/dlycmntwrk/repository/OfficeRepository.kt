package gdsc.knu.dlycmntwrk.repository

import gdsc.knu.dlycmntwrk.domain.Office
import org.springframework.data.jpa.repository.JpaRepository

interface OfficeRepository : JpaRepository<Office, Long> {

}