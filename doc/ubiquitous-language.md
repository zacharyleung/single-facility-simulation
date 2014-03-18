The purpose of this project is to study how well a replenishment policy
performs in a simple supply chain with a single facility,
under different lead time models, report delays and demand models.

In each period, the following events occur:

 1. If a **shipment** is scheduled to arrive at the **facility** at the
    current period, then the inventory level of the facility is
    incremented by X units.
 2. If the **schedule** indicates that the current period is a reporting
    period, then the **facility** submits a **report** to the
    **supplier**.  The **supplier** may receive the **report**
    instantaneously, or with a delay of several weeks, as specified by
    the **schedule**.
 3. If the **supplier** has received a **report**, then based on the
    **replenishment policy**, it will calculate a replenishment
    quantity of X units.  A **shipment** of X units of the product will
    be scheduled to arrive after a lead time of l periods.
 4. Customers arrive at the **facility** and demand X units of the
    product.  Any unmet demand is lost.

