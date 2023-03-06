package gdsc.knu.dlycmntwrk.dto

import gdsc.knu.dlycmntwrk.domain.Office

data class OfficeDto(
    val id: Long,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val items: List<Any>,
    val riskLevel: Double
)

fun officeToOfficeDto(office: Office): OfficeDto {
    return OfficeDto(
        id = office.id!!,
        name = office.name,
        latitude = office.location.y,
        longitude = office.location.x,
        items = emptyList(),
        riskLevel = 50.0
    )
}