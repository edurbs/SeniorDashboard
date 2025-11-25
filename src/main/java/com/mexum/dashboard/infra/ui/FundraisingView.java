package com.mexum.dashboard.infra.ui;

import com.mexum.dashboard.app.dto.OutstandingInvoicesDTO;
import com.mexum.dashboard.app.dto.SupplierBalanceDTO;
import com.mexum.dashboard.app.service.FundraisingService;
import com.mexum.dashboard.app.service.SupplierService;
import com.mexum.dashboard.infra.ui.component.ViewToolbar;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Route("")
@PageTitle("Duplicatas de financiamentos")
@Menu(order = 1, icon = "vaadin:clipboard-check", title = "Duplicatas de financiamentos")
public class FundraisingView extends Main {

    public FundraisingView (SupplierService supplierService, FundraisingService fundraisingService){

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.of("pt", "BR"));
        DecimalFormat decimal = new DecimalFormat("#,##0.00", symbols);

        Grid<SupplierBalanceDTO> suppliersGrid = new Grid<>();

        suppliersGrid.addColumn(SupplierBalanceDTO::getId)
                .setHeader("Código")
                .setAutoWidth(true)
                .setSortable(true)
                .setComparator(SupplierBalanceDTO::getId);
        suppliersGrid.addColumn(SupplierBalanceDTO::getTradeName)
                .setHeader("Nome Fantasia")
                .setAutoWidth(true)
                .setSortable(true)
                .setComparator(SupplierBalanceDTO::getTradeName);
        suppliersGrid.addColumn(dto -> decimal.format(dto.getBalance()))
                .setHeader("Saldo Devedor")
                .setAutoWidth(true)
                .setSortable(true)
                .setTextAlign(ColumnTextAlign.END)
                .setComparator(SupplierBalanceDTO::getBalance);

        suppliersGrid.setItems(supplierService.getSuppliersWithBalance());

        suppliersGrid.setItemDetailsRenderer(createDetailsRenderer(fundraisingService));

        suppliersGrid.setSizeFull();
        setSizeFull();

        addClassNames(LumoUtility.BoxSizing.BORDER, LumoUtility.Display.FLEX, LumoUtility.FlexDirection.COLUMN,
                LumoUtility.Padding.MEDIUM, LumoUtility.Gap.SMALL);
        add(new ViewToolbar("Duplicatas de financiamentos"), suppliersGrid);
    }

    private static ComponentRenderer<DetailsFormLayout, SupplierBalanceDTO> createDetailsRenderer(FundraisingService fundraisingService){
        return new ComponentRenderer<>(() ->
                new DetailsFormLayout(fundraisingService),
                DetailsFormLayout::setDetails);
    }

    private static class DetailsFormLayout extends Div {

        private final Grid<OutstandingInvoicesDTO> fundraisingGrid;
        private final FundraisingService fundraisingService;

        public DetailsFormLayout(FundraisingService fundraisingService){
            this.fundraisingService = fundraisingService;

            DateTimeFormatter birthdayFormatter = DateTimeFormatter
                    .ofPattern("MM/dd/yyyy");
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.of("pt", "BR"));
            DecimalFormat decimal = new DecimalFormat("#,##0.00", symbols);

            fundraisingGrid = new Grid<>();

            fundraisingGrid.addColumn(OutstandingInvoicesDTO::getContractId)
                    .setHeader("Código")
                    .setAutoWidth(true)
                    .setSortable(true)
                    .setComparator(OutstandingInvoicesDTO::getContractId);
            fundraisingGrid.addColumn(OutstandingInvoicesDTO::getBankContractNumber)
                    .setHeader("Nº. Bancário")
                    .setAutoWidth(true)
                    .setSortable(true)
                    .setComparator(OutstandingInvoicesDTO::getBankContractNumber);
            fundraisingGrid.addColumn(dto -> dto.getContractDate().format(birthdayFormatter))
                    .setHeader("Data")
                    .setAutoWidth(true)
                    .setSortable(true)
                    .setComparator(OutstandingInvoicesDTO::getContractDate);
            fundraisingGrid.addColumn(OutstandingInvoicesDTO::getContractDescription)
                    .setHeader("Descrição")
                    .setAutoWidth(true)
                    .setSortable(true)
                    .setComparator(OutstandingInvoicesDTO::getContractDescription);
            fundraisingGrid.addColumn(dto -> decimal.format(dto.getBalance()))
                    .setHeader("Saldo Devedor")
                    .setAutoWidth(true)
                    .setSortable(true)
                    .setComparator(OutstandingInvoicesDTO::getBalance)
                    .setTextAlign(ColumnTextAlign.END);
            fundraisingGrid.setSizeFull();

            addClassNames(LumoUtility.Height.AUTO);
            setSizeFull();

            add(fundraisingGrid);
        }

        public void setDetails(SupplierBalanceDTO supplierBalanceDTO){
            Integer supplierId = supplierBalanceDTO.getId();
            List<OutstandingInvoicesDTO> invoices = fundraisingService.getOutstandingInvoicesOfSupplier(supplierId);
            fundraisingGrid.setItems(invoices);
            int size = 50 + 50 * invoices.size();
            setHeight(size+"px");

        }
    }

}
