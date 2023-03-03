package gdsc.knu.dlycmntwrk.domain

import jakarta.persistence.*
import java.io.Serializable

@Embeddable
data class ItemCountKey(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    var item: Item,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    var office: Office
) : Serializable {
    companion object {
        private const val serialVersionUID = -7868655889532070601L
    }
}