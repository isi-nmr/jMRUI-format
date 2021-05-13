package jMruiFormat;

public enum TAGS {
//    EchoTime,
//    RepetitionTime,
//    InversionTime,
//    MixingTime,
//    ExcitationFlipAngle,
//    TxOffset,
// minimum report
    Field_strength ("Field strength"),
    Manufacturer ("Manufacturer" ),
    Model  ("Model (software version if available)" ),
    RF_coils ("RF coils" ),
    Nuclei ("Nuclei"),
    Additional_hardware ("Additional hardware" ),
    Pulse_sequence ("23NA" ),
    VOI ("Volume of interest (VOI) locations" ),
    Nominal_VOI_size ("Nominal VOI size [cm3, mm3]" ),
    EchoTime ("Echo Time"),
    RepetitionTime ("Repetition time (TR)" ),
    Total_number_of_excitations_or_acquisitions_per_spectrum  ("Total number of excitations or acquisitions per spectrum" ),
    NA_per_time_point ("Number of averaged spectra (NA) per time point" ),
    Averaging_method ("Averaging method" ),
    Total_number_of_spectra ("Total number of spectra" ),
    MixingTime ("Mixing time" ),
    SpectralWidth("Spectral Width"),
//    If MRSI: 2D or 3D, FOV in all directions, matrix size, acceleration factors, sampling method
    Water_suppression_method ("Water suppression method"),
    Shimming_method ("Shimming method" ),
    Reference_peak  ("Reference peak" ),
    thresholds_for_acceptance_of_shim ("thresholds for “acceptance of shim” chosen" ),
//    Triggering or motion correction method
    Analysis_software ("Analysis software" ),
    Processing_steps ("Processing steps deviating from quoted reference or product" ),
    Output_measure ("Output measure" ),
    Quantification_references_and_assumptions ("Quantification references and assumptions, fitting model assumptions" ),
    Reported_variables ("Reported variables"),
    Data_exclusion_criteria ("Data exclusion criteria" ),
    Quality_measures ("Quality measures of postprocessing model fitting" ),
    Sample_spectrum ("Sample spectrum" ),
    InversionTime ("Inversion time"),
    TxOffset ("TxOffset"),
    ExcitationFlipAngle ("ExcitationFlipAngle"),
    // extra parameters
    CarrierFrequency("CarrierFrequency");
    private final String name;

    TAGS(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
