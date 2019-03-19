package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Offer {

    private List<OfferItem> availableItems = new ArrayList<OfferItem>();

    private List<OfferItem> unavailableItems = new ArrayList<OfferItem>();

    public Offer(List<OfferItem> availabeItems, List<OfferItem> unavailableItems) {
        this.availableItems = availabeItems;
        this.unavailableItems = unavailableItems;
    }

    public List<OfferItem> getAvailableItems() {
        return availableItems;
    }

    public List<OfferItem> getUnavailableItems() {
        return unavailableItems;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Offer offer = (Offer) o;
        return Objects.equals(availableItems, offer.availableItems) && Objects.equals(unavailableItems, offer.unavailableItems);
    }

    @Override public int hashCode() {
        return Objects.hash(availableItems, unavailableItems);
    }

    /**
     *
     * @param seenOffer
     * @param delta
     *            acceptable difference in percent
     * @return
     */
    public boolean sameAs(Offer seenOffer, double delta) {
        if (availableItems.size() != seenOffer.availableItems.size()) {
            return false;
        }

        for (OfferItem item : availableItems) {
            OfferItem sameItem = seenOffer.findItem(item.getProductId());
            if (sameItem == null) {
                return false;
            }
            if (!sameItem.sameAs(item, delta)) {
                return false;
            }
        }

        return true;
    }

    private OfferItem findItem(String productId) {
        for (OfferItem item : availableItems) {
            if (item.getProductId().equals(productId)) {
                return item;
            }
        }
        return null;
    }

}
